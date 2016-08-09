# My Bonnie
_Android library allowing to preserve instance of any object accross orientation changes._

### Specs
* Lightweight < 20kB
* Clear & Flexible API (Using composition instead of forcing inheritance)
* Java 8 ready

### Usage

### Sample scenario
The purpose of Bonnie lib was to provide simple and robust cache for presenters in MVP architecture. In MVP approach often there is a need to preserve presenter from being destroyed during orientation change of activty. 

### The magic
Bonnie uses Android Loader API under the hood. Loaders are providing an API to handle asynchronous data loading in activity or fragment. The Bonnie lib uses them to provide simple way of caching (preserving) instances of objects that mustn't be destroyed during orientation changes. Instances being preserved are destroyed when the activity holding them is no longer abandoned. 

### Motto
_Last night as I lay on my pillow_<br>
_Last night as I lay on my bed_<br>
_Last night as I lay on my pillow_<br>
_I dreamt that my Bonnie was dead_<br>
_Oh, blow the winds o'er the ocean_<br>
_And blow the winds o'er the sea_<br>
_Oh, blow the winds o'er the ocean_<br>
_And bring back my Bonnie to me!_<br>

