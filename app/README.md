# ✈️ GetPassengers App

## 📖 App Description
The **GetPassengers** app allows users to create and manage passenger lists. The app starts with the
**MainActivity** screen, displaying a **GET PASSENGER LIST** button alongside an empty **Returned 
Passenger List**. When the button is pressed, the app navigates to a second screen 
(**GetPassengersActivity**), where users can input passenger information including **first name**, 
**last name**, and **phone number**. The entered passengers are displayed in an accumulating list on 
the second screen. Once the list is finalized, the user can return to the main screen, where the 
completed **Returned Passenger List** is displayed, showing each passenger on a new line.

## ⚙️ Challenges and Solutions
- **Challenge:** Implementing `registerForActivityResult` for data transfer between activities.
    - **Solution:** I referred to the **Lecture 2 Random Numbers** example from class, which helped 
    - clarify how the `registerForActivityResult` callback works. By following that example, I was 
    - able to correctly send passenger data from the second activity back to the main screen.

## 📚 Key Learnings
During this project, I learned how to use **registerForActivityResult** to dynamically send and 
receive data between activities in Kotlin. I also gained a better understanding of how to use 
**ConstraintLayout** to position UI elements and how to dynamically update **TextViews** with user 
input. Once I understood how to pass data using an **Intent** with key-value pairs, the entire 
process became clearer.

## 🔮 Future Improvements
If I had more time, I would add **database storage** to save passenger lists, allowing users to 
access their lists even after closing the app. I would also implement an **edit/delete feature** to 
modify passenger entries before sending the list back to the main screen. Additionally, users could 
**browse past passenger lists** based on a selected date.