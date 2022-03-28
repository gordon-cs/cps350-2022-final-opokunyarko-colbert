# cps350-2022-final-bazaar-opokunyarko-colbert


# BAZAAR

Bazaar is an area that is always used for shopping. It can be a marketplace or a street of shops where things are exchanged or sold.


## TARGET USERS:

Bazaar is a trade and barter oriented marketplace for users interested in trading their items with others.


## WHAT PROBLEM DOES THIS SOLVE?

It is an easy way for people without (enough) money to get what they need in exchange for something they already have. Users also get the chance to communicate among themselves to be able to negotiate the value of products to be exchanged or purchased.


## PRIMARY FEATURES:

Bazaar will feature a simple product listing UI through which users can search, trade, postListing, viewListing, and sendMessage.


## APIs TO BE USED


[SharedPreferences:](https://developer.android.com/jetpack/androidx/releases/datastore)

* This API helps in storing key-value pairs such as the users settings, IDs, name
We will be using this in our Users profile page to store the users name and other useful information about the user

[AppSearch:](https://developer.android.com/jetpack/androidx/releases/appsearch)
      
* An on-device search library for managing locally stored structured data. We will use it to build custom in-app search capabilities for users.

[Google Content for Shopping:](https://developers.google.com/shopping-content/guides/products/products-api)
      
* This lets users insert, get, update and delete one product at a time. We will use this to help Users upload products, update products and delete products when they successfully sell them.


## PROTOTYPE

Our prototype is expected to demonstrate Bazaar’s persistent storage system with Android’s DataStore/Room APIs and Google’s Content API. It will support search and trade features. While a nice addition to our app, messaging may not be an achievable goal by the prototype deadline. 


## BAZAAR'S UI
      

## HOME SCREEN
![1](https://user-images.githubusercontent.com/78819149/160342010-bb3492d9-19bf-4571-95d2-6cdddd384d12.png)
      		
  
  
## MESSAGING SCREEN
![2](https://user-images.githubusercontent.com/78819149/160342023-8e145c21-a35f-4b1a-b05e-acbb0039763d.png)
  
  
## SEARCH SCREEN
![3](https://user-images.githubusercontent.com/78819149/160342041-9cf5463f-6bfa-48ae-aa33-6c52f87fb69a.png)
  
## Profiles Page
![4](https://user-images.githubusercontent.com/78819149/160342077-de90af18-9747-4a87-88f5-495c440c9eed.png)

  
## Useful Android APIs

* Databinding: Bind UI components in layouts to data sources in app. (For browsing shopping items?)
* DataStore: Store data asynchronously, consistently, and transactionally, overcoming some of the drawbacks of SharedPreferences
* Autofill: Improve autofill accuracy via extending hints
* CameraX: Add camera capabilities to app
* Room: Create, store and manage persistent data backed by a SQLite database
* App Search: Build custom in-app search capabilities for your users.
* Savedstate: Components that save UI state.
* CardView: Implement the Material Design card pattern with round corners and drop shadows.

## Useful RESTful APIs

* Google Content API for Shopping: Database of products specific to a seller/app and will not contain data that isn't put in ourselves







