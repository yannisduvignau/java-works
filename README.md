# ☕ java-works

A curated collection of **Java exercises and mini-projects** covering core computer science concepts — from sorting algorithms and multithreading to socket programming and classic games.

---

## 📋 Description

**java-works** is a hands-on Java learning repository. Each folder is a self-contained project targeting a specific concept or programming challenge. Topics range from fundamental algorithms and data structures to system-level programming with threads, sockets, and file I/O.

---

## 🗂️ Projects Overview

| Folder | Description |
|--------|-------------|
| [`bubble_sort`](#-bubble-sort) | Implementation of the Bubble Sort algorithm |
| [`element_search_with_threads`](#-element-search-with-threads) | Parallel element search using multiple threads |
| [`file_copy`](#-file-copy) | File duplication using Java I/O streams |
| [`minesweeper`](#-minesweeper) | Console-based Minesweeper game |
| [`npi`](#-npi--reverse-polish-notation) | Reverse Polish Notation (RPN) calculator |
| [`parking`](#-parking) | Parking lot management simulation |
| [`server_socket`](#-server-socket) | Client-server communication via sockets |
| [`threading`](#-threading) | Java threading and concurrency fundamentals |

---

## 📦 Project Details

### 🔢 Bubble Sort
> `bubble_sort/`

A classic sorting algorithm implemented in Java. Iteratively compares adjacent elements and swaps them until the array is fully sorted.

**Concepts covered:** arrays, loops, algorithm complexity O(n²)

---

### 🔍 Element Search with Threads
> `element_search_with_threads/`

Searches for a target element within a large dataset by splitting the workload across multiple threads. Demonstrates how parallelism can improve search performance.

**Concepts covered:** `Thread`, `Runnable`, parallel search, workload splitting

---

### 📄 File Copy
> `file_copy/`

Reads a source file and writes its content to a new destination file using Java's I/O API.

**Concepts covered:** `FileInputStream`, `FileOutputStream`, `BufferedReader`, `BufferedWriter`, exception handling

---

### 💣 Minesweeper
> `minesweeper/`

A fully playable Minesweeper game running in the console. The player uncovers cells on a grid, avoiding hidden mines.

**Concepts covered:** 2D arrays, game logic, recursive flood-fill reveal, user input

---

### 🧮 NPI — Reverse Polish Notation
> `npi/`

A calculator implementing the **Reverse Polish Notation** (RPN / Postfix) evaluation algorithm using a stack.

**Concepts covered:** `Stack`, expression parsing, postfix evaluation, operator precedence

---

### 🅿️ Parking
> `parking/`

Simulates a parking lot management system — handling vehicle entries, exits, and slot availability.

**Concepts covered:** Object-Oriented Programming (OOP), classes, encapsulation, collections

---

### 🌐 Server Socket
> `server_socket/`

A basic TCP client-server application. The server listens on a port and exchanges messages with a connected client.

**Concepts covered:** `ServerSocket`, `Socket`, `InputStream`, `OutputStream`, network programming

---

### 🔀 Threading
> `threading/`

Explores Java's concurrency model with examples of thread creation, synchronization, and coordination.

**Concepts covered:** `Thread`, `Runnable`, `synchronized`, `wait()`, `notify()`, race conditions

---

## 🚀 Getting Started

### Prerequisites

- [Java JDK](https://adoptium.net/) 8 or higher
- A terminal or an IDE (IntelliJ IDEA, Eclipse, VS Code)

---

### Compile & Run

Navigate into any project folder, then:

```bash
# Compile
javac FileName.java

# Run
java FileName
```

**Example — Bubble Sort:**

```bash
cd bubble_sort
javac BubbleSort.java
java BubbleSort
```

**Example — Server Socket (two terminals):**

```bash
# Terminal 1 — Start the server
cd server_socket
javac Server.java
java Server

# Terminal 2 — Start the client
javac Client.java
java Client
```

---

## 🧠 Concepts Covered

| Category | Topics |
|----------|--------|
| Algorithms | Bubble Sort, Linear/Parallel Search, RPN evaluation |
| Data Structures | Arrays, Stack, Collections |
| OOP | Classes, Encapsulation, Inheritance |
| Concurrency | Threads, Runnable, Synchronization |
| I/O | File reading/writing, Stream handling |
| Networking | TCP Sockets, Client-Server architecture |
| Game Logic | 2D grid, Recursive reveal, User input |

---

## 🤝 Contributing

1. Fork the project
2. Create your branch (`git checkout -b feature/new-exercise`)
3. Commit your changes (`git commit -m 'Add new Java exercise'`)
4. Push to the branch (`git push origin feature/new-exercise`)
5. Open a Pull Request

---

## 👤 Author

**Yannis Duvignau**  
[GitHub](https://github.com/yannisduvignau)

---

## 📄 License

This project is distributed under an open license. See the `LICENSE` file for more details.