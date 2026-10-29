# Sistema de Registro de Integrantes - Arquitectura MVC en Java Swing

## 1. Objetivo
Aplicación de escritorio en Java desarrollada bajo el patrón arquitectónico **Modelo-Vista-Controlador (MVC)** y **Programación Orientada a Objetos (POO)**. Permite registrar integrantes de proyectos educativos, validar sus datos (incluyendo la URL de su repositorio de GitHub), almacenarlos dinámicamente en memoria mediante `ArrayList<Integrante>` y consultarlos en tiempo real a través de una tabla (`JTable`).

## 2. Requisitos del Sistema
* **Java Development Kit (JDK):** Versión 8, 11, 17 o 21+.
* **IDE recomendado:** IntelliJ IDEA, Apache NetBeans, Eclipse o VS Code con Extension Pack for Java.

## 3. Estructura del Proyecto
```text
src/
├── model/
│   └── Integrante.java           # Entidad con atributos encapsulados, getters, setters y toString()
├── view/
│   └── FormularioIntegrante.java # Interfaz gráfica en Java Swing (JFrame, JTable, controles)
├── controller/
│   └── IntegranteController.java # Manejo de eventos, validaciones y gestión del ArrayList
└── Main.java                     # Punto de entrada de la aplicación