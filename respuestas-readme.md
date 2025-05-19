##  Respuestas

###  Inyección de dependencia en el constructor

Tener la inyección de la dependencias en el constructor de la siguiente manera:

```java
public EarlyBirdController(@Autowired(required = false) EarlyBirdDiscountService discountService) {
    this.earlyBirdDiscountService = discountService;
}
```

Me da la flexibilidad de indicar que el servicio **podría no estar disponible**.  
Considerando que este servicio de ofertas puede **habilitarse o deshabilitarse** a través del `application.properties`, esta forma de inyectar la dependencia es la **más apropiada en este caso**.

---

###  Ventajas y desventajas de pre-request y post-response en pruebas automatizadas con Postman

**Pre-request Script (antes de la petición):**

✅Ventajas:
- Permite definir o modificar **variables dinámicas** (tokens, fechas, IDs, etc.).
- Útil para preparar el entorno antes de enviar la solicitud.



**Test (post-response):**

 Ventajas:
- Permite validar el **código de estado**, cuerpo de respuesta y guardar variables para próximas peticiones.
- Es el lugar correcto para **automatizar validaciones y aserciones**.

---

###  Comportamiento de la aplicación con early bird deshabilitado

Cuando `feature.earlybird.enabled=false`, la aplicación responde con un **mensaje indicando que dicho servicio está deshabilitado**.

---

###  Desafíos

- Gestionar correctamente **la disponibilidad condicional** del servicio (activado o no).
- Implementar **manejo de errores robusto**.
- Asegurar que los endpoints sigan funcionando con o sin el servicio activo.
- Integrar correctamente los tests de Postman para validar ambos escenarios.
