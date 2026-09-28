# Practicas_Java

## 🚀 Prácticas de Java y Programación Orientada a Objetos (POO)

Repositorio dedicado al aprendizaje, práctica y documentación de conceptos clave de Java y la Programación Orientada a Objetos.

---

### 📌 ¿Qué es la Programación Orientada a Objetos (POO)?

La POO es un paradigma de programación basado en el concepto de **objetos**, los cuales representan entidades del mundo real combinando **atributos** (datos/características) y **métodos** (comportamiento/acciones).

---

### 🧱 Los 4 Pilares de la POO

- **Abstracción:** Representar únicamente las características esenciales de un objeto para el sistema, ignorando los detalles innecesarios.
- **Encapsulamiento:** Proteger el estado interno de un objeto restringiendo el acceso directo a sus atributos mediante modificadores de acceso (`private`) y exponiendo métodos seguros (`getters` y `setters`).
- **Herencia:** Permite que una clase hija (`extends`) reutilice los atributos y métodos de una clase padre, promoviendo la reutilización de código.
- **Polimorfismo:** Capacidad de objetos de distintas clases de responder al mismo mensaje o método de maneras diferentes (usando la anotación `@Override`).

---

### 🔑 Conceptos Clave en Java y Diseño

- **Clase vs. Objeto:** Una **clase** es el molde o plantilla; un **objeto** es una instancia concreta creada a partir de esa plantilla usando la palabra clave `new`.
- **Clase Abstracta vs. Clase Concreta:**
  - *Clase abstracta (`abstract class`):* Es una clase que no se puede instanciar directamente; sirve como modelo base incompleto para que otras clases hereden de ella y definan sus comportamientos pendientes (métodos abstractos).
  - *Clase concreta:* Es una clase completa con todas las implementaciones de sus métodos definidas, lista para ser instanciada con `new`.
- **Interface (`interface`):** Un contrato formal que define qué métodos debe tener una clase sin especificar cómo implementarlos (todos sus métodos abstractos y constantes son públicos por defecto). Una clase puede implementar múltiples interfaces (`implements`), logrando herencia múltiple de comportamiento.
- **Métodos `default` y Resolución del Diamante:**
  - *Métodos default:* Métodos con implementación dentro de una interfaz (introducidos en Java 8) que permiten añadir funcionalidad sin romper las clases existentes.
  - *Problema del diamante:* Si una clase implementa dos interfaces que contienen el mismo método `default`, el compilador genera un conflicto de ambigüedad. La clase que implementa está obligada a sobrescribir (`@Override`) dicho método para decidir explícitamente cuál comportamiento adoptar (por ejemplo, invocando `InterfazA.super.metodo()`).
- **Sobrecarga (Overloading):** Definir en una misma clase varios métodos con el mismo nombre pero con diferentes parámetros.
- **Sobrescritura (Overriding):** Redefinir en una clase hija un método que ya fue declarado en la clase padre.
- **Manejo de Excepciones:** Estructura `try-catch-finally` empleada para capturar errores en tiempo de ejecución (`ArithmeticException`, `InputMismatchException`) sin romper el programa.
- **¿Por qué instanciar un producto? ¿Hay varios productos?:**
  - La clase `Producto` define los atributos generales (nombre, precio, stock).
  - Cada vez que se ejecuta `new Producto(...)` se crea una **instancia independiente en memoria** con sus propios valores. Por ejemplo, `producto1` puede ser un monitor y `producto2` un teclado; ambos comparten la misma estructura pero contienen estados y datos distintos.
- **Desarrollo por Especificaciones (Design by Contract / BDD):** Metodología donde el diseño de clases e interfaces se establece a partir de requerimientos claros, contratos, precondiciones y postcondiciones antes o durante la codificación. Garantiza que el código cumpla con exactitud lo que el sistema o el cliente espera que haga.

---

### 🛠️ Buenas Prácticas al Programar

- **Una clase por archivo:** Nombrar el archivo `.java` exactamente igual a la clase `public` que contiene.
- **Convención Naming Standard:**
  - **Clases:** `PascalCase` (ej. `CabinaPeaje`).
  - **Variables y Métodos:** `camelCase` (ej. `calcularPeaje`).
  - **Constantes:** `UPPER_SNAKE_CASE` (ej. `TARIFA_BASE`).
- **Clean Code:** Escribir código legible, indentado y con nombres descriptivos para variables y métodos.

---

### 🐙 Gestión de Proyecto y Control de Versiones (Git / GitHub)

- **Issue:** Registro o ticket en GitHub para reportar errores (bugs), solicitar nuevas funciones o iniciar debates sobre mejoras del proyecto.
- **Task (Tarea):** Unidad atómica de trabajo técnico derivada de una funcionalidad o de un issue, orientada a completarse en un paso concreto del desarrollo.
- **Bifurcación (Fork):** Copia completa de un repositorio ajeno a tu propia cuenta de GitHub, permitiéndote experimentar y hacer cambios de forma aislada sin afectar el proyecto original.
- **Push:** Acción de enviar confirmaciones locales (`commits`) desde tu computadora hacia el repositorio remoto en GitHub (`git push origin main`).
- **Pull Request (PR):** Solicitud formal para integrar los cambios realizados en una rama o fork dentro de la rama principal del repositorio, permitiendo revisión de código y validación antes de fusionar (`merge`).
