# 📚 Sistema de Gestión de Biblioteca Universitaria

<p align="center">
  <img src="Imagenes/Disgrama de clases.png" alt="Diagrama de clases" width="600"/>
</p>

Proyecto desarrollado para la asignatura **Programación III** en la **UNLaR** (Departamento Académico de Ciencias Exactas, Físicas y Naturales).

## 🎯 Objetivo
Consolidar los fundamentos de la Programación Orientada a Objetos aplicando encapsulamiento, estructuras de datos y manejo de excepciones en un contexto de gestión de préstamos bibliotecarios.

## 🚀 Funcionalidades Principales
* **Gestión de Entidades:** Modelado completo de Libros, Estudiantes y Préstamos.
* **Sistema de Colecciones:**
    * `ArrayList` para el catálogo de libros.
    * `HashMap` para el registro de estudiantes (clave: legajo).
    * `HashSet` para préstamos activos, garantizando unicidad mediante `equals()` y `hashCode()`.
* **Validaciones de Negocio:**
    * Verificación de disponibilidad de ejemplares.
    * Límite máximo de 3 libros por estudiante.
* **Cálculo de Multas:** Algoritmo recursivo que aplica un 1% por día de retraso (máximo 30 días).

## 🛠️ Manejo de Excepciones
El sistema implementa robustez mediante excepciones personalizadas:
1. `LibroNoDisponibleException`
2. `EstudianteNoEncontradoException`
3. `LimitePrestamosExcedidoException`

## 🏗️ Estructura del Proyecto

El código está organizado en paquetes siguiendo buenas prácticas de desarrollo:
* `model`: Clases de datos.
* `exception`: Definición de errores personalizados.
* `service`: Lógica de negocio y gestión de colecciones.
* `ui`: Interfaz de consola y casos de prueba.

  
<p align="center">
  <img src="Imagenes/Diagrama UML.png" alt="Diagrama UML" width="600"/>
</p>

## 📋 Requisitos Técnicos
* Getters y Setters
* Constructores
* JavaDoc

---

## 👨‍💻 Desarrolladores / Integrantes del equipo

<p align="center">
  <table>
    <tr>
      <td align="center">
        <a href="https://github.com/IsmaDeveloper16">
          <h3>Ismael Flores</h3>
          <img src="Imagenes/Isma AURA.jpeg" width="200"/>
        </a>
      </td>
      <td align="center">
        <a href="https://github.com/franlar020">
          <h3>Francisco Antonio Gonzalez</h3>
          <img src="Imagenes/Fran AURA.jpeg" width="200"/>
        </a>
      </td>
    </tr>
  </table>
</p>
