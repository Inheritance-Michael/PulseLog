# PulseLog 📱✨

> A modern, offline-first personal habit & micro-journal Android application built as an open-source collaborative showcase for intermediate developers.

[![Android](https://img.shields.io/badge/Platform-Android-3DDC84?logo=android&logoColor=white)](https://developer.android.com)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.x-7F52FF?logo=kotlin&logoColor=white)](https://kotlinlang.org)
[![Compose](https://img.shields.io/badge/Jetpack%20Compose-UI-4285F4?logo=jetpackcompose&logoColor=white)](https://developer.android.com/jetpack/compose)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

---

## 🎯 About PulseLog

**PulseLog** is designed to bridge the gap between simple tutorial apps and bloated enterprise codebases. It is built by developers, for developers, to explore modern Android architecture, reactive data streams, home-screen widgets, and **on-device artificial intelligence**—all while maintaining a strict 100% offline-first, privacy-first architecture.

---

## 🚀 Key Features

* **Habit Tracking & Streaks:** Custom habit creation, categories, color accents, tactile one-tap check-ins, and reactive streak calculations.
* **Micro-Journal & Mood Scale:** Quick daily mood selection (5-level scalar) paired with a 280-character micro-journal reflection and a calendar heatmap view.
* **On-Device AI Weekly Summaries:** Leverages **ML Kit GenAI / Gemini Nano via AICore** to generate offline weekly motivational reflections. Includes a robust, deterministic **rule-based fallback engine** for devices without supported NPU hardware.
* **System Assistant Integration:** Exposes core capabilities (`logHabit`, `recordMood`) via **Android AppFunctions** so system assistants can interact with the app.
* **Jetpack Glance Widgets:** Interactive 2x2 and 4x2 home-screen widgets for logging habits without opening the app process.
* **Custom Analytics Dashboard:** Visual completion rings and trend matrices built natively using Compose Canvas and Graphics APIs.

---

## 🏛️ Architecture & Tech Stack

PulseLog adheres to **Clean Architecture** principles and a **Unidirectional Data Flow (UDF)** model using MVVM/MVI.

* **UI Framework:** Jetpack Compose & Material 3 (with Dynamic Color support)
* **Navigation:** Jetpack Compose Navigation with Kotlin Serialization (Type-Safe Routes)[cite: 1]
* **Local Persistence:** Room Database with reactive `Flow` and `StateFlow`[cite: 1]
* **Dependency Injection:** Hilt[cite: 1]
* **Asynchrony:** Kotlin Coroutines & Flow[cite: 1]
* **Widgets:** androidx.glance (`glance-appwidget`)[cite: 1]
* **On-Device AI:** `com.google.mlkit:genai-prompt` & Android AppFunctions[cite: 1]

---

## 📂 Multi-Module Structure

```text
PulseLog/
├── app/                  # Application entry point, Hilt container, top-level NavHost
├── core/
│   ├── model/            # Pure Kotlin domain data models (Zero Android dependencies)
│   ├── database/         # Room DB, DAOs, entities, and repository implementations
│   ├── ai/               # ML Kit GenAI wrapper, capability checks, and fallbacks
│   └── ui/               # Material 3 theme tokens, shared Compose Canvas components
├── feature/
│   ├── dashboard/        # Today's habits, check-in UI, and streak metrics
│   ├── journal/          # Micro-journal feed and timeline calendar
│   └── insights/         # Analytics charts and AI weekly reflection card
└── widget/               # Jetpack Glance home screen app widgets
