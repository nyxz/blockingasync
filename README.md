#### The idea

We have the typical REST service that returns `CompletableFuture<String>` (Here we don't actually have the exact REST Controller but we have the `Server` class to simulate the server request).
Then the `Server` class calls `AService.a()`, which does some processing then it call another service - `BService.b()`.
Since we need to return the `Server`'s thread back to the thread pool ASAP the call to `AService.a()` is asynchronous. Then since the `BService.b()` is implemented as asynchronous method we got a nested asynchronous method invocation.
This is bad since it can exhaust the thread pool and cause some thread to wait the second level of invocation, but the second level does not have where to get thread from. Hence we get blocked.
