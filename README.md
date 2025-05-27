# 📚 Bookshelf App – Jetpack Compose + Google Books API

Aplicación desarrollada como parte del curso **Programación en Móviles** en **TECSUP**.

Esta app permite buscar libros a través de la **API pública de Google Books**, visualizar los resultados en una cuadrícula e ingresar a una vista de detalle con información extendida de cada libro.

---

## 👨‍🎓 Datos del proyecto

- **Curso**: Programación en Móviles  
- **Institución**: TECSUP  
- **Estudiante**: Guerra Pacheco George Miky 
- **Fecha**: Mayo 2025  
- **Docente**: Brian Benjamin Pareja Meruvia

---

## 🛠️ Tecnologías utilizadas

- ✅ **Jetpack Compose**
- ✅ **Kotlin**
- ✅ **MVVM Architecture**
- ✅ **Retrofit + Gson**
- ✅ **Google Books API**
- ✅ **Coil** (para carga de imágenes)
- ✅ **State management con LiveData/State**

---

## 📱 Funcionalidades principales

| Funcionalidad         | Descripción                                                                 |
|-----------------------|-----------------------------------------------------------------------------|
| 🔍 Búsqueda de libros | Permite buscar por título, autor o palabra clave.                           |
| 🖼 Vista en cuadrícula| Muestra las portadas de los libros en una grilla adaptable.                 |
| 📘 Vista detallada    | Muestra información completa: título, autor, editorial, descripción, etc.   |
| 🔁 Navegación         | Permite ir y volver entre la lista y el detalle con `NavHost`.              |


## 🔌 API utilizada

Esta app usa la [Google Books API](https://developers.google.com/books/docs/v1/using) para obtener información pública sobre libros.  
No se requiere autenticación para las consultas básicas.
