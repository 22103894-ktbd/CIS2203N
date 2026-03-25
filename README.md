Exercise 02 – Part 1: UI Wireframe Implementation

Student Information:
Name: Kyle C. Tubod
Course: BS Information Technology
Exercise: Exercise 02 – Part 1


Overview:

This project focuses on translating a given wireframe design into an Android layout using **ConstraintLayout**. The goal is to accurately replicate the provided UI design while applying proper layout constraints,
spacing, and alignment.

Objective:

Convert the provided wireframe into an XML layout
Use ConstraintLayout for positioning UI elements
Apply correct margins, sizes, and constraints
Ensure proper alignment and overlapping of elements

Layout Description
The layout consists of a centered **ID Card design** with the following components:

Card Container:

Fixed size (300dp x 420dp)
Centered on screen
White background

Logo (Top Left)

Positioned at the top-left corner of the card
Margin: 16dp (start), 24dp (top)

Profile Image (Top Right)

Positioned at the top-right corner
Size: 120dp x 120dp

ID Badge:

Overlaps the profile image
Positioned using constraints and negative margin
Styled with blue background and white text

Name:

Displays student name
Baseline aligned with ID badge


QR Code:

Positioned at the bottom center
Uses match constraints (0dp width) with side margins


Technologies Used:

Java
XML Layout
ConstraintLayout
Android Studio


Key Concepts Applied:

Constraint-based positioning
Baseline alignment
View overlapping using negative margins
Proper use of `0dp` (match constraints)
Clean and minimal layout structure

How to Run:

1. Open the project in Android Studio
2. Connect an emulator or physical device
3. Run the application
4. The screen will display the ID Card wireframe layout


Output:

The application displays a static ID card UI that matches the provided wireframe design, including proper alignment, spacing, and overlapping elements.

Conclusion:
The wireframe was successfully implemented using ConstraintLayout. The layout follows the required design specifications and demonstrates proper use of Android UI development principles.
