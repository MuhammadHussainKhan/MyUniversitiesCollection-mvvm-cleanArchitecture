# MyUniversitiesCollection-mvvm-cleanArchitecture
This is a multi-module Android application showcasing various architecture and design components. The project is structured to demonstrate clean architecture, efficient dependency management, and modern Android development practices.

# Features
Multi-Module Architecture: Divided into multiple modules for better code organization and maintainability.
Navigation in Multi-Module: Smooth navigation between different modules using Android Navigation Component.
Centralized Dependency Management: All Gradle dependencies are managed in a single place using a version catalog.
Clean Architecture: Separation of concerns with layers for data, domain, and presentation.
Caching: Efficient data caching mechanisms implemented across modules.
Room Database: Local data storage using Room.
Dagger Hilt: Dependency injection with Dagger Hilt.
Retrofit: Network operations using Retrofit.
Swipe to Refresh: Pull to refresh functionality.
Kotlin & XML: Entirely built using Kotlin and XML.
View Binding: Type-safe access to views.
# Project Structure
 *Modules*
app: The main app module containing the application class and initial setup.
common: Contains core utilities, Room Db and common classes used across other modules.
uni: Manages showing university list .
details: university details.

# Layers
Data Layer: Implements data sources (local and remote) and repositories.
Domain Layer: Contains use cases and business logic.
Presentation Layer: Includes UI components, ViewModels, and navigation logic.
#Getting Started
*Prerequisites*
Android Studio 4.2 or higher
Kotlin 1.9 or higher
Gradle 7.0 or higher
