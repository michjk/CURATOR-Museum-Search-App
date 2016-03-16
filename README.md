# brogrammers-project

#Setting Up Project
1. Run Android Studio
2. Select File->New Project
3. App name: CURATOR, Company domain: cz2006.com
4. Min SDK android 4.4
5. Choose Google Maps Activity
6. New Project created

#Setting up github
1. install git from https://git-scm.com/
2. create new folder as a temporary folder for source code downloaded from github
3. go inside the folder, right click, and choose git bash
4. type "git clone https://github.com/michjk/brogrammers-project.git"
5. the brogrammers folder are downloaded to the temp folder
6. copy the content inside the brogrammers folder to CURATOR\app\src\main

#Update source code from github
1. go to the brogrammers folder and run git bash
2. type "git pull origin master"
3. The source code is updated from github
   Note: everytime you want to work, always pull from github first
4. Copy the source code to your project

#Upload source code to github
1. copy source code inside main folder to brogrammers folder
2. run git bash at that folder
3. type "git add ." to include all file in the folder
4. type " git commit -m "your message" ". "your message" should be brief and concise.
5. type "git push origin master"
6. The source code is uploaded
7. If there is a conflict, just delete brogrammers folder and start setting up github again, 
   and try to identify manually which part should be modified by you.

For the UI, try to use card view and recycler view to show data.


