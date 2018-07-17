# Google Developer Scholarship with Udacity

## NewsApp v1.1

#### Version 1.1 aka Preferential

![NewsApp v1.1 animation](http://g.recordit.co/Hur6GeDHA0.gif)

#### Version 1.0 aka Base

![NewsApp v1 animation](http://g.recordit.co/wRxnBDKfam.gif)

### Project Overview

For this project I created a News feed app which gives a user regularly-updated news from the internet related to a particular topic. In my case I used the Brexit News because I'm a European citizen living in Britain and it helps to know how the situation is progressing.

### Design Inspiration

A mix between the old school BBC branding and The Guardian's card styles.

### Why this project?
  
A good way to prove knowledge of HTTP Networking in Android as well as a firm grip on using API for populating view.  
  
### Tools

The Guardian's News API used in the following formats

```
http://content.guardianapis.com/search?q=debates&api-key=test
```

```
https://content.guardianapis.com/search?q=debate&tag=politics/politics&from-date=2014-01-01&api-key=test
```
AsyncTask and Loaders were using throughout this project as we as ListView's and their corresponding adapters.

### What will I learn?

This project is about combining various ideas and skills we’ve been practicing throughout the course. They include:
* Populating a ListView from an API
* Fetching data from an API via AsyncTasks and Loaders
* Parsing the response from the API
* Learning how to open the HTTP connection and properly log the errors that could crop up in the process
* How to cover for edge cases: empty lists and no internet connection
* How to provide snappy feedback to a user whilst the app is performing a task
* Multi-threading and how to avoid memory leaks 
* Using intents to open a link from a ListView item into the user's browser of choice
* Creating a dynamic 'preferences screen' with preference summaries and the ability to change different preferences

### Extra challenges

* Implementing two fetch tasks inside the same Loader
* Abstracting away code based on levels
* Material Design Card interations for onTap events

### Requirements

#### Layout

##### Main Screen

App contains a main screen which displays multiple news stories.

##### List Item Contents

- Each list item on the main screen displays relevant text and information about the story.

- The title of the article and the name of the section that it belongs to are required field.

- If available, author name and date published should be included. Please note not all responses will contain these pieces of data, but it is required to include them if they are present.

- Images are not required.

##### Layout Best Practices

The code adheres to all of the following best practices:
- Text sizes are defined in sp
- Lengths are defined in dp
- Padding and margin is used appropriately, such that the views are not crammed up against each other.


#### Functionality 

##### Main Screen Updates

Stories shown on the main screen update properly whenever new news data is fetched from the API.

##### Errors

The code runs without errors.

##### Story Intents

Clicking on a story uses an intent to open the story in the user’s browser.

##### API Query

App queries the content.guardianapis.com api to fetch news stories related to the topic chosen by the student, using either the ‘test’ api key or the student’s key.

##### JSON Parsing

The JSON response is parsed correctly, and relevant information is stored in the app.

##### No Data Message

When there is no data to display, the app shows a default TextView that informs the user how to populate the list.

##### Response Validation

The app checks whether the device is connected to the internet and responds appropriately. The result of the request is validated to account for a bad server response or lack of server response.

##### Use of Loaders

Networking operations are done using a Loader rather than an AsyncTask.

##### External Libraries and Packages

The intent of this project is to give you practice writing raw Java code using the necessary classes provided by the Android framework; therefore, the use of external libraries for the core functionality will not be permitted to complete this project.

#### Code Readibility

##### Readability

Code is easily readable such that a fellow programmer can understand the purpose of the app.

##### Naming Conventions

All variables, methods, and resource IDs are descriptively named such that another developer reading the code can easily understand their function.

##### Formatting

The code is properly formatted i.e. there are no unnecessary blank lines; there are no unused variables or methods; there is no commented out code.
