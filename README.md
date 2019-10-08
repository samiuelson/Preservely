# Preservely
_Android library allowing to preserve instance of any object across orientation changes._

Note that the library should be considered depreceated now because Google deprecated Loaders API in favour to using ViewModel class instead. You can read more here: https://developer.android.com/guide/components/loaders.

[![](https://jitpack.io/v/samiuelson/Preservely.svg?style=flat-square)](https://jitpack.io/#samiuelson/Preservely)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Preservely-green.svg?style=flat-square)](https://android-arsenal.com/details/1/4311)


### Specs
* Lightweight (5kB jar)
* Clear & Flexible API (Using composition instead of forcing inheritance)
* Java 8 ready...
```java
Preserver.init(this, 23,
                (PreservedInstanceFactory<MyTypeToBePreserved>) () -> new MyTypeToBePreserved(),
                (Preserver.OnInstanceReloadedAction<MyTypeToBePreserved>) instance -> {
                    // do sth when instance is reloaded
                },
                (Preserver.OnInstanceDestroyedAction) () -> {
                    // do sth when instance is destroyed
                }
);
```
### Usage
* Add the JitPack repository to your build file:
```gradle
	allprojects {
		repositories {
			// ...
			maven { url "https://jitpack.io" }
		}
	}
```

* Add the dependency
```gradle
	dependencies {
	        compile 'com.github.samiuelson:Preservely:0.0.4'
	}
```
* In your Activity / Fragment onCreate call 
```java
Preserver.init(
		this, // activity instance
		23, // id of loader used
		new PreservedInstanceFactory<MyTypeToBePreserved>() { // factory for the instance that should be preserved
		    @Override
		    public MyTypeToBePreserved create() {
		        return new MyTypeToBePreserved();
		    }
		},
		new Preserver.OnInstanceReloadedAction<MyTypeToBePreserved>() {
		    @Override
		    public void performAction(MyTypeToBePreserved instance) {
		        // do sth when instance is reloaded
		    }
		},
		new Preserver.OnInstanceDestroyedAction() {
		    @Override
		    public void performAction() {
		        // do sth when instance is destroyed
		    }
		}
);
```
### Purpose
The aim of Preservely lib creation is to provide simple and robust cache for presenters' instances in MVP architecture. In MVP approach, there often is a need to keep presenter instance from being destroyed during activity orientation change. You can check out the sample project to see how it's working in action.

### The magic
Preservely uses Android Loader API under the hood. On Android platform, Loaders framework provides API for asynchronous data loading in Activity or Fragment. However, Loaders has special property of preserving instance of the handled object when it's reloaded. Preservely benefits from that to provide simple way of caching (preserving) instances of objects that mustn't be destroyed during orientation changes. Preserved instances are destroyed when the activity holding them is  abandoned and no longer used.

## License
    Copyright Samuel Urbanowicz   
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

