A simple *kinda* complex guessing game? There's better ways of writing the majority of the code here, use it if you want, 
but it would likely be in your best interest to make something completely custom. 

If there's anything worth examining this project for, it's a bug I experienced when working on this, specifically with Arrays, methods and Null.
I would get the error `Cannot invoke "Player.getName()" because "this.pArray[i]" is null`, looking around online I couldn't find a fix, but I
figured out my issue, incase this happens to popup in search results and anyone is in the same boat I was, here's what I did.

Do fill the array at the top of the script and do not have any self existing "Player" objects. When a new Player Object is created, just put it
into the array, if looping, just overwrite the old one. instead of writing "p1.getName()", you'd write something like "pArray[0].getName()".
This ended up working, and while it's less "clean" feeling than a bunch of self existing objects, it does work, and it probably fixed another 
bug I had yet to encounter due to looping.

edit like 2 months later: alternatively you could just use ArrayLists instead of being a fucking idiot (like me)
