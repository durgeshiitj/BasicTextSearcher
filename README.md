# BasicTextSearcher
This project is created to search words of a sentences in files and gives the matching percent for each file inside a directory.

### Prerequisites

You will need below things to be installed in your system

```
Text Editor
Java Version 8
```

### Running the program

A runnable jar has been provided along with the code. This jar can be run using the following command in a command prompt

```
Open Command prompt.
Go to the directory where jar is saved.
Create a new Directory and keep some text files in it.
```
now in command prompt, run following:
```
java - jar <jarfileName.jar> <path_to_a_directory>
```


### Things to know
* If the directory is invalid, the program will return an error stating about the illegal directory.
* If the directory contains other than text files then program will give messages that files are invalid with file name
* An empty directory will print a warning message as well and it will exit the system.
* User needs to provide a valid directory with valid text files.

## Walkthrough to the service
* after running the command  ``` java - jar <jarfileName.jar> <path_to_a_directory> ``` user will get screen to either provide a text to search or use ```:quit```  to quit the system.
* if provide empty string or whitespaces the system will give feedback to provide a valid group of words such as ```Please provide a word to search```.
* enter any text. for ex. ```to be or not to be ```.
* the above texts will get searched in all the files and if there is a match then it will return the file name with the matching precentage.

## Note:
* Each word in the sentence provided by the user will get seached separately. Search function is not searching exact whole sentence but the words from the sentence.
* Text search is case insensitive. eg ```to``` is same as ```TO```.
* the special characters will not be searched. Numbers will get searched.


## Running in Eclipse
* the main method to run is ```SearchMain.java```
* from the eclipse, this service can be direcly run.
* simply run the java class by giving the path_to_a_directory
* with this service, a sample testDirectory has been given with 3 text files