# Refactorización: FacturacionLegacy.java  
**Alumno:** Elena Sáez  
**Módulo:** Entorno de Desarrollo

## Descripción

En este README comento los cambios realizados sobre el método `cT` de la clase `FacturacionLegacy.java`. El objetivo ha sido eliminar la deuda técnica sin alterar el comportamiento funcional del código, refactorizándolo.  
**Nota importante:** Mi análisis de la lógica del código refactorizado está comentada **DENTRO** del Commit de refactorización, no en el código.

--- 
## Tres grandes problemas del código antiguo:  
1. **Números mágicos:** Valores como 0.25 o 0.15 están hardcodeados sin ningún contexto.
2. **Variables sin significado:** Nombres como `cT, m, tC o dV` no dicen nada. Obligan a adivinar qué representan.
3. **Código Spaghetti:** La anidación de múltiples `if-else` crea una estructura de forma de flecha **>** que hace casi imposible seguir la lógica del algoritmo.
   
## Cambios Realizados

### 1. Renombrado de variables y método

Se han renombrado todos los identificadores usando las herramientas automáticas del IDE para evitar errores tipográficos y garantizar la coherencia en todo el archivo.

| Nombre original | Nombre refactorizado     |
|-----------------|--------------------------|
| `cT`            | `calcularTotal`          |
| `m`             | `importeBase`            |
| `tC`            | `tipoCliente`            |
| `dV`            | `esSocioVip`             |

---

### 2. Extracción de constantes

Los valores numéricos se han extraído como constantes `private static final` con nombres mejor escogidos, situadas en la cabecera de la clase.

| Valor original | Constante creada            |
|----------------|-----------------------------|
| `0.25`         | `DESCUENTO_VIP`             |
| `0.15`         | `DESCUENTO_ESTANDAR`        |
| `0.05`         | `DESCUENTO_SECUNDARIO`      |
| `1`            | `TIPO_CLIENTE_PREMIUM`      |
| `2`            | `TIPO_CLIENTE_SECUNDARIO`   |

---

### 3. Cláusulas de guarda

Se ha eliminado por completo la anidación de bloques `if-else`, reduciendo la complejidad de algoritmia del método.

**Antes:** estructura anidada con múltiples niveles de `if-else`.  
**Después:** cada condición comprueba su caso con un return, sin bloques `else`.

---

### 4. Documentación JavaDoc

Se ha añadido el documento JavaDoc sobre el método `calcularTotal` que documenta:

- **Propósito** del método.
- **`@param importeBase`**: importe bruto de la transacción.
- **`@param tipoCliente`**: tipo de cliente (1 = Premium, 2 = Secundario).
- **`@param esSocioVip`**: si el cliente tiene condición VIP.
- **`@return`**: importe final tras descuento, o `0` si el importe no es válido.

---

## Resultado

Los tests unitarios de `FacturacionLegacyTest.java` pasan en verde antes y después de la refactorización, confirmando que el comportamiento del negocio no ha sido alterado.

---

## Consultas IA

### #1

| Campo | Detalle |
|-------|---------|
| **Agente** | Claude |
| **Prompt** | *"Tengo este método Java con variables sin nombre descriptivo y números hardcodeados. ¿Cómo lo refactorizo renombrando las variables y extrayendo las constantes correctamente?"* |
| **Respuesta** | El agente me explicó cómo renombrar las variables usando el refactor automático del IDE (VsCode) para garantizar el cambio en todo el archivo sin errores tipográficos, y cómo extraer los valores numéricos como constantes `private static final` en la cabecera de la clase con nombres como `DESCUENTO_VIP` o `TIPO_CLIENTE_PREMIUM`. |

### #2

| Campo | Detalle |
|-------|---------|
| **Agente** | Claude |
| **Prompt** | *"¿Cómo se genera correctamente un bloque JavaDoc para un método en Java?"* |
| **Respuesta** | El agente me indicó que el bloque JavaDoc se escribe justo encima del método con `/** ... */` y que debe incluir una descripción general del propósito del método, una etiqueta `@param` por cada parámetro explicando qué representa y sus valores válidos, y una etiqueta `@return` describiendo qué devuelve el método y en qué condiciones. |

---
