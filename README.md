# Guessing Game App
[Aiden Munsamy]
 [StNo.ST10470773]
[IMAD5111]
[Higher certificate in mobile application and web development ]
-----------------------------------------------------------------------------------------

## Links
- **GitHub Repository**: []
- **YouTube Video**: []

--------------------------------------------------


## Project Overview

The Guessing Game App is an Android application designed to test users' knowledge with a series of true or false questions. Users are presented with statements and must decide if they are true or false. The app tracks the user's score and provides feedback on their answers. Once all questions are answered, the game ends, and the user's final score is displayed, along with an option to review the questions and their correct answers. The app features a simple, interactive UI with a background video to enhance the user experience.

----------------------------------------------------------------------------

## Purpose and Features

### Purpose:
The Guessing Game App aims to provide an engaging and fun way for users to test their general knowledge. It challenges users with a variety of true or false statements, encouraging them to think critically and learn new facts. The app is designed to be a simple yet entertaining quiz game suitable for a wide audience.

### Key Features:

-   **Question Display:**
    -   **Description:** The app presents users with a series of true or false questions one at a time.
    -   **Functionality:** Questions are loaded from a predefined list within the application. Each question is clearly displayed on the screen.
    -   **User Interaction:** Users read the displayed question before making their selection.

-   **Answer Selection (True/False):**
    -   **Description:** Users can select whether they believe the displayed statement is true or false.
    -   **Functionality:** Two distinct buttons, "True" and "False," are provided for user input. Once an answer is selected, these buttons are temporarily disabled for the current question.
    -   **User Interaction:** Users tap either the "True" or "False" button to submit their answer.

-   **Immediate Feedback:**
    -   **Description:** After submitting an answer, the app immediately informs the user if their choice was correct or incorrect.
    -   **Functionality:** A text view displays "Correct!" or "Incorrect!" based on the user's answer compared to the predefined correct answer. The user's score is updated accordingly if the answer is correct.
    -   **User Interaction:** Users see the feedback message on the screen.

-   **Next Question Navigation:**
    -   **Description:** After answering a question and receiving feedback, users can proceed to the next question.
    -   **Functionality:** A "Next" button becomes visible after an answer is submitted. Tapping this button loads the subsequent question. If all questions have been answered, the game transitions to an "end game" state.
    -   **User Interaction:** Users tap the "Next" button to continue the game.

-   **Scoring System:**
    -   **Description:** The app keeps track of the user's score throughout the game.
    -   **Functionality:** The score increments by one for each correctly answered question. The final score is displayed at the end of the game.

-   **Game Over State:**
    -   **Description:** Once all questions have been presented, the game concludes.
    -   **Functionality:** A "Game Over!" message is displayed along with the user's final score. The question display area is hidden, and the true/false buttons are disabled. A "Review Answers" button becomes visible.

-   **Review Answers:**
    -   **Description:** After the game ends, users have the option to review all the questions, their submitted answers (implicitly, by knowing the correct answers), and the correct answers.
    -   **Functionality:** Tapping the "Review Answers" button navigates the user to a new screen (`DisplayScoreScreenActivity`). This screen lists all the questions from the game and their corresponding correct answers. The user's final score is also passed to this screen.
    -   **User Interaction:** Users tap the "Review Answers" button to move to the review screen.

-   **Background Video:**
    -   **Description:** The game screen features a looping background video to enhance visual appeal.
    -   **Functionality:** A `VideoView` plays a video resource in a loop.
    -   **User Interaction:** The video plays automatically in the background.

------------------------------------------------------------------------------------

## Design Considerations

The design of the Guessing Game App was based on the following key considerations:

-   **User Experience (UX):** The app was designed to be straightforward and engaging. The flow of the game – question, answer, feedback, next – is intuitive. Clear visual cues are provided for game state and user actions.
-   **Simplicity:** The UI is kept clean and focused on the core gameplay. The primary interactions (answering questions and navigating) are prominent and easy to understand.
-   **Interactivity:** Immediate feedback and a clear progression system aim to keep the user engaged. The background video adds a dynamic visual element without being distracting.
-   **Clarity:** Questions and feedback messages are presented clearly. Button states (enabled/disabled, visible/gone) change appropriately to guide the user.

-------------------------------------------------------------------------------

## GitHub and GitHub Actions


This project is managed using **GitHub** for version control. All code changes are committed and pushed regularly to the repository. GitHub allows for tracking changes, collaboration, and maintaining project integrity.

### GitHub Actions:

I utilize **GitHub Actions** to automate parts of the development lifecycle. This includes:
-   Automated builds on each push to the main branch to ensure the code compiles successfully.
-    Running automated tests to verify app functionality.
-    Generating APK and AAB files for distribution.

-----------------------------------------------------------------------------------------------------------

## App Screenshots:
![Screenshot 2025-05-22 112700](https://github.com/user-attachments/assets/72c10621-2ab9-46fa-98b3-1e16c6f292ce)

![Screenshot 2025-05-22 112652](https://github.com/user-attachments/assets/1ebf63bb-35b8-4e4f-9ed4-156d0f26dd64)

![Screenshot 2025-05-22 112708](https://github.com/user-attachments/assets/884fe5fe-c52d-4979-98e0-3a11fc4ccbbd)

![Screenshot 2025-05-22 112839](https://github.com/user-attachments/assets/561fb4ca-bc70-4e25-801a-81436d8a6e33)

---------------------------------------------------------------------------------------------------

## Video Demo:



A video showcasing the app's functionality can be viewed here: [Link to your video demo]


---------------------------------------------------------------------------------------------------

## Challenges and Learnings

During the development of the Guessing Game App, I encountered several challenges and gained valuable learnings:

-   **Challenge 1: Managing Game State.**
    -   **Description:** Keeping track of the current question, the user's score, and whether a question has been answered required careful state management.
    -   **Solution:** I used instance variables (`currentQuestionIndex`, `score`, `answered`) within the `Game_Display` Activity to manage the game's state. Functions like `displayQuestion()` and `checkAnswer()` were designed to update and react to these state variables, ensuring the UI reflected the current game progress accurately.

-   **Challenge 2: Dynamically Updating UI Elements.**
    -   **Description:** Buttons needed to be enabled/disabled, and text views needed to change based on user actions and game progression (e.g., showing/hiding the "Next" button, displaying feedback).
    -   **Solution:** I learned to manipulate UI element properties like `isEnabled` and `visibility` directly in Kotlin code in response to events. For example, after an answer, `trueButton` and `falseButton` are disabled, and `nextButton` becomes visible.

-   **Challenge 3: Passing Data Between Activities.**
    -   **Description:** For the "Review Answers" feature, the list of questions, their correct answers, and the final score needed to be passed from `Game_Display` Activity to `DisplayScoreScreenActivity`.
    -   **Solution:** I utilized `Intent` extras to pass this data. `putStringArrayListExtra` was used for the lists of questions and answers (converting boolean answers to strings), and `putExtra` was used for the integer score. This involved understanding how to package data into an Intent and retrieve it in the receiving Activity.

-   **Challenge 4: Implementing Background Video Playback.**
    -   **Description:** Adding a looping background video required using the `VideoView` component and handling its lifecycle.
    -   **Solution:** I learned to initialize `VideoView`, set its URI using `android.resource://`, and use `setOnPreparedListener` to start playback and enable looping once the video was ready. This also involved ensuring the video resource was correctly placed in the `res/raw` directory.

-   **Challenge 5: Structuring Questions and Answers.**
    -   **Description:** Storing and accessing the questions and their corresponding correct answers in an organized way was important for the game'


----------------------------------------------------------------------

## Future Enhancements
While the current version of the Guessing Game App provides a fun and functional quiz experience, there are several features that could be added in the future to make it even more engaging and robust:

##Expanded Question Database & Categories:

- Integrate a much larger and more diverse set of questions.
- Introduce question categories (e.g., Science, History, Geography, Pop Culture) allowing users to choose topics they are interested in or play a mixed-category game.
- Potentially load questions from an external source like a JSON file, a local SQLite/Room database, or even a remote API for dynamic content updates.

##Difficulty Levels:

## Implementing different difficulty levels (e.g., Easy, Medium, Hard).
- This could involve curating question sets for each level or assigning a difficulty rating to individual questions.

## Timed Mode / Time Limits per Question:
- Adding an optional timed mode where users have a limited amount of time to answer each question or complete the entire quiz.
- This would add an extra layer of challenge and excitement.

## User Accounts and High Scores:
- Allow users to create simple profiles to track their progress and high scores.
- Implement a local or online leaderboard to foster competition.

## Hints System:
- Provide an option for users to get a hint for a difficult question, perhaps at the cost of some points or a limited number of hints per game.

## More Detailed Feedback/Explanations: 
- Instead of just "Correct!" or "Incorrect!", provide a brief explanation or interesting fact related to the question, especially for incorrect answers. This would enhance the learning aspect of the game.

## Customizable Game Settings:
- Allow users to customize settings like the number of questions per game, sound effects on/off, or even the background video (if multiple options were provided).

## Improved UI/UX and Animations:
- Further refine the visual design with more polished graphics, smoother transitions, and engaging animations for events like correct/incorrect answers or game completion.
- Consider Material Design 3 components for a modern look and feel.

## Sound Effects and Music:
- Add sound effects for correct/incorrect answers, button clicks, and game events.
Include background music options to enhance the atmosphere.

## Multiplayer Mode:
- Introduce a local multiplayer mode (e.g., pass-and-play) or even a networked multiplayer mode where users can compete against each other in real-time.

## Achievements and Rewards:
- Implement an achievement system where users can unlock badges or rewards for reaching certain milestones (e.g., answering a certain number of questions correctly, achieving a perfect score).
-------------------------------------------------------------------------------

## references

1. The Independent Institute of Education. (2025) Introduction to Mobile Application Development:
 IMAD5112/p/w Module Manual. [Module Manual]. South Africa: The Independent Institute of Education (Pty) Ltd.

2. AstroPlaneet (2024) Space and universe wallpaper at 120fps. [TikTok video]. 29 December.
 Available at: https://vm.tiktok.com/ZMSF94kom/ (Accessed: 22 May 2025).
