The application uses MVP as its architecture, but instead of interfaces the application uses abstract classes to allow a basic implementation of common functionality such as setting the view contract
Retrofit2 is used as the networking library and all responses from the Dog.ceo api are wrapped in retrofit2.Response. It uses Gson for parsing the JSON payloads
The list fragment display a list of dog breeds and the detail fragment displays 10 random images of the selected dog breed
The presenters have been unit tested using JUnit4 and MockK
Koin was used for dependency injection of the presenters and Retrofit services
Glide was used for image loading instead of coil(used initially) as it was thought that coil was causing slow scrolling of the recyclerview for dog images. This was later found to be an issue due to the
nested scroll view and not the image loading libraries.

I added the test coroutine dispatcher to each test class instead of creating a rule as this was a simple application with only two coroutines and wasn't concerned with scalability
I would like to have added usecases instead of directly implementing the api calls in the presenter as this would be much cleaner and easier to maintain