# Preservely
_Android library allowing to preserve instance of any object accross orientation changes._

### Specs
* Lightweight < 20kB
* Clear & Flexible API (Using composition instead of forcing inheritance)
* Java 8 ready

### Usage
`// TODO`

### Sample scenario
The aim of Preservely lib creation was to provide simple and robust cache for presenters instances in MVP architecture. In MVP approach often there is a need to keep presenter instance from being destroyed during orientation change of activty. 

### The magic
Preservely uses Android Loader API under the hood. On Android platform Loaders framework is providing API to handle asynchronous data loading in activity or fragment. However, Loaders has special property of preserving instance of the object when it's reloaded. Preservely benefits from that to provide simple way of caching (preserving) instances of objects that mustn't be destroyed during orientation changes. Instances being preserved are destroyed when the activity holding them is  abandoned and no longer used.

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

