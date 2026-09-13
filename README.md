# Practicas_Java

# 🚀 Prácticas de Java y Programación Orientada a Objetos (POO)

Repositorio dedicado al aprendizaje, práctica y documentación de conceptos clave de Java y la Programación Orientada a Objetos.

---

## 📌 ¿Qué es la Programación Orientada a Objetos (POO)?
La POO es un paradigma de programación basado en el concepto de **objetos**, los cuales representan entidades del mundo real combinando **atributos** (datos/características) y **métodos** (comportamiento/acciones).

---

## 🧱 Los 4 Pilares de la POO

1. **Abstracción:** Representar únicamente las características esenciales de un objeto para el sistema, ignorando los detalles innecesarios.
2. **Encapsulamiento:** Proteger el estado interno de un objeto restringiendo el acceso directo a sus atributos mediante modificadores de acceso (`private`) y exponiendo métodos seguros (`getters` y `setters`).
3. **Herencia:** Permite que una clase hija (`extends`) reutilice los atributos y métodos de una clase padre, promoviendo la reutilización de código.
4. **Polimorfismo:** Capacidad de objetos de distintas clases de responder al mismo mensaje o método de maneras diferentes (usando la anotación `@Override`).

---

## 🔑 Conceptos Clave en Java

* **Clase vs. Objeto:** Una **clase** es el molde o plantilla; un **objeto** es una instancia concreta creada a partir de esa plantilla usando la palabra clave `new`.
* **Sobrecarga (Overloading):** Definir en una misma clase varios métodos con el mismo nombre pero con diferentes parámetros.
* **Sobrescritura (Overriding):** Redefinir en una clase hija un método que ya fue declarado en la clase padre.
* **Manejo de Excepciones:** Estructura `try-catch-finally` empleada para capturar errores en tiempo de ejecución (`ArithmeticException`, `InputMismatchException`) sin romper el programa.

---

## 🛠️ Buenas Prácticas al Programar

* **Una clase por archivo:** Nombrar el archivo `.java` exactamente igual a la clase `public` que contiene.
* **Convención Naming Standard:**
  * **Clases:** `PascalCase` (ej. `CabinaPeaje`).
  * **Variables y Métodos:** `camelCase` (ej. `calcularPeaje`).
  * **Constantes:** `UPPER_SNAKE_CASE` (ej. `TARIFA_BASE`).
* **Clean Code:** Escribir código legible, indentado y con nombres descriptivos para variables y métodos.
