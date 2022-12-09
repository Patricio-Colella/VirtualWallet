### INSTRUCCIONES 

-crear base de datos postgreSQL llamada "virtualWallet"
-en carpeta VirtualWallet\src\main\resources\application.properties reemplazar:

spring.datasource.username=nombre de usuario de postgres
spring.datasource.password=contraseña de usuario de postgres

-correr src\main\java\StackTrace\VirtualWallet\VirtualWalletApplication.java

1. [Rutas **usuario**](#rutas-usuario)
   - [GET usuarios](#get-usuarios)
   - [GET usuario por dni](#get-usuario-dni)
   - [GET usuario billeteras-saldos](#get-usuario-billeteras)
   - [POST usuario](#post-usuario)
   - [PUT usuario](#put-usuario)
   - [DELETE usuario](#delete-usuario)
2. [Rutas **billetera**](#rutas-billetera)
   - [GET billeteras](#get-billetera)
   - [GET billetera por cvu](#get-billetera-cvu)
   - [POST billetera](#post-billetera)
   - [PUT billetera](#put-billetera)
   - [DELETE billetera](#delete-billetera)
3. [Rutas **divisa**](#rutas-billetera)
   - [GET divisas](#get-divisa)
   - [POST divisa](#post-divisa)
   - [PUT divisa](#put-divisa)
   - [DELETE divisa](#delete-divisa)
4. [Rutas **transaccion**](#rutas-transaccion)
   - [GET transaccion](#get-transaccion)
   - [POST transaccion](#post-transaccion)
---

## RUTAS **usuario**

---

### GET **usuarios**

- **RUTA**: "localhost:8080/api/usuario"

- **DESCRIPCION**: esta ruta es para devolver todos los usuarios existentes en la base de datos

- **REQUERIMIENTOS**: ninguno

- **RESPUESTA**: un arreglo que contiene toda la info de los usuarios

    [
        {
            "dni": "dni unico",
            "genero": "hombre-mujer",
            "nombre": "nombre del usuario",
            "apellido": "apellido del usuario",
            "email": "correo del usuario",
            "telefono": "telefono del usuario",
            "billeteras": [
                "id de su/sus billetera/s"
            ]
        }
    ]

---

### GET **usuario dni**

- **RUTA**: "localhost:8080/api/usuario/{idUsuario}"

- **DESCRIPCION**: esta ruta es para devolver un usuario buscado por dni

- **REQUERIMIENTOS**: requiere por parametros el dni unico del usuario, y por query la contraseña del mismo (contrasña=)

- **RESPUESTA**: un objeto que contiene toda la info de el usuario

    {
        {
            "dni": "dni unico",
            "genero": "hombre-mujer",
            "nombre": "nombre del usuario",
            "apellido": "apellido del usuario",
            "email": "correo del usuario",
            "telefono": "telefono del usuario",
            "billeteras": [
                "id de su/sus billetera/s"
            ]
        }
        billeteras:[
            {
                "cvu": "cvu unico de la billetera",
                "saldo": saldo actual de la billetera,
                "usuario": "dni del usuario",
                "recepciones": [
                    "numero identificador de transferencia recibidas"
                ],
                "emiciones": [
                    "numeros identificador de transferencia emitida"
                ],
                "divisas": [
                    "numero identificador de divisa con la que cuenta en su saldo"
                ]
            }
        ]
    }

---

### GET **usuario billeteras**

- **RUTA**: "localhost:8080/api/usuario/misBilleteras/{idUsuario}"

- **DESCRIPCION**: esta ruta es para devolver informacion acerca de los saldos de las billeteras de un usuario

- **REQUERIMIENTOS**: requiere por parametros el dni unico del usuario, y por query la contraseña del mismo (contraseña= )

- **RESPUESTA**: un arreglo que contiene las billeteras de el usuario

[
    {
        "cvu": "cvu unico de la billetera",
        "saldo": "saldo actual de la billetera",
        "usuario": "dni del usuario",
        "recepciones": [
            "numero identificador de transferencia recibidas"
        ],
        "emiciones": [
            "numeros identificador de transferencia emitida"
        ],
        "divisas": [
            "numero identificador de divisa con la que cuenta en su saldo"
        ]
    },
]

---

### POST **usuario**

- **RUTA**: "localhost:8080/api/usuario"

- **DESCRIPCION**: esta ruta es para crear un usuario nuevo en la base de datos

- **REQUERIMIENTOS**: requiere por body un objeto de clase usuario (dni,genero,nombre,apellido,email,telefono,contraseña)

- **RESPUESTA**: vacio, comprobar usuario creado con ruta get

---

### PUT **usuario**

- **RUTA**: "localhost:8080/api/usuario/{idUsuario}

- **DESCRIPCION**: esta ruta es para modificar las propiedades de un usuario (exceptuando su dni)

- **REQUERIMIENTOS**: requiere por parametros el dni unico del usuario, y por body un objeto de tipo usuario(dni,genero,nombre,apellido,email,telefono,contraseña)(exceptuando dni)

- **RESPUESTA**: vacio, comprobar con ruta get 

---

### DELETE **usuario**

- **RUTA**: "localhost:8080/api/usuario/{idUsuario}"

- **DESCRIPCION**: esta ruta es para eliminar un usuario de la base de datos, borrando asi tambien sus billeteras

- **REQUERIMIENTOS**: requiere por parametros el dni unico del usuario

- **RESPUESTA**: vacio, comprobar con ruta get

---

## RUTAS **billetera**

---

### GET **billeteras**

- **RUTA**: "localhost:8080/api/billetera"

- **DESCRIPCION**: esta ruta es para devolver todas las billeteras existentes en la base de datos

- **REQUERIMIENTOS**: ninguno

- **RESPUESTA**: un arreglo que contiene toda la info de las billeteras

    [
        {
            "cvu": "cvu unico de la billetera",
            "saldo": saldo de la billetera,
            "usuario": "dni del usuario",
            "recepciones": [
                "numero identificador de transferencia recibidas"
            ],
            "emiciones": [
                "numeros identificador de transferencia emitida"
            ],
            "divisas": [
                "numero identificador de divisa con la que cuenta en su saldo"
            ]  
        },
    ]

---

### GET **billetera cvu**

- **RUTA**: "localhost:8080/api/billetera/billeteraUnica/{cvuBilletera}"

- **DESCRIPCION**: esta ruta es para devolver los datos de una billetera especifica

- **REQUERIMIENTOS**: cvu de la billetera pasada por parametros

- **RESPUESTA**: un objeto referido a una billetera especifica

    {
        "cvu": "cvu unico de la billetera",
        "saldo": saldo de la billetera,
    },

---

### POST **billetera**

- **RUTA**: "localhost:8080/api/billetera/{dniUsuario}

- **DESCRIPCION**: esta ruta es para crear una billetera para un usuario

- **REQUERIMIENTOS**: por parametros se requiere el dni del usuario

- **RESPUESTA**: vacio, comprobar con ruta get

---

### PUT **billetera**

- **RUTA**: "localhost:8080/api/billetera/deposito/{cvuBilletera}

- **DESCRIPCION**: esta ruta es para cargar un deposito a una billetera

- **REQUERIMIENTOS**: por query se requiere contraseña(contraseña=) y dni(dni=) del usuario, y a su vez monto(saldo=) y tipo de divisa (tipoDivisa=), ademas por parametros se requiere el cvu de la billetera

- **RESPUESTA**: vacio, comprobar con ruta get

---

### DELETE **billetera**

- **RUTA**: "localhost:8080/api/billetera/{idBilletera}

- **DESCRIPCION**: esta ruta es eliminar una billetera de la base de datos

- **REQUERIMIENTOS**: por parametros se requiere el cvu de la billetera

- **RESPUESTA**: vacio, comprobar con ruta get

---

## RUTAS **divisa**

---

### GET **divisa**

- **RUTA**: "localhost:8080/api/divisa"

- **DESCRIPCION**: esta ruta es para devolver todas las divisas disponibles en la base de datos. Aquellas divisas con cantidad = null son las usadas como referencia para determinar si la divisa es utilizable para los usuarios

- **REQUERIMIENTOS**: ninguno

- **RESPUESTA**: un arreglo que contiene toda la info de las divisas

    [
        {
            "id": "identificacion unica de la divisa",
            "nombre": "nombre de la divisa",
            "valor_pesos": "valor de la divisa",
            "cantidad": cantidad de esta divisa en la billetera que la contenga
        },
    ]
---

### POST **divisa**

- **RUTA**: "localhost:8080/api/divisa

- **DESCRIPCION**: esta ruta es para crear una divisa en la base de datos para ser utilizada por los usuarios

- **REQUERIMIENTOS**: por body se requiere un objeto de tipo divisa (nombre= nombre de la divisa,valor_pesos= valor en pesos de la divisa) 

- **RESPUESTA**: vacio, comprobar con ruta get

---

### PUT **divisa**

- **RUTA**: "localhost:8080/api/divisa/{tipo}

- **DESCRIPCION**: esta ruta es para editar el valor en pesos de una divisa

- **REQUERIMIENTOS**: por query se requiere el nuevo valor de la divisa (valor=), y por parametros se requiere el nombre de la divisa a modificar 

- **RESPUESTA**: vacio, comprobar con ruta get

---

### DELETE **divisa**

- **RUTA**: "localhost:8080/api/billetera/{idBilletera}

- **DESCRIPCION**: esta ruta es eliminar una divisa de la base de datos

- **REQUERIMIENTOS**: por parametros se requiere el nombre de la divisa a eliminar 

- **RESPUESTA**: vacio, comprobar con ruta get

---

## RUTAS **transaccion**

---

### GET **transaccion**

- **RUTA**: "localhost:8080/api/transaccion"

- **DESCRIPCION**: esta ruta es para devolver todas las transacciones realizadas 

- **REQUERIMIENTOS**: ninguno

- **RESPUESTA**: un arreglo que contiene toda la info de las transacciones

    [
        {
            "id": "identificacion unica de la transaccion",
            "fecha_ingreso": "fecha de transaccion",
            "hora_ingreso": "hora de transaccion",
            "operacion": "deposito/envio/recibo",
            "cantidad": "cantidad de la divisa especifica enviada",
            "divisa": "nombre de la divisa enviada",
            "billeteraEmisora": "cvu de la billetera emisora",
            "billeteraReceptora": "cvu de la billetera receptora"
        }
    ]
---

### POST **transaccion**

- **RUTA**: "localhost:8080/api/transaccion

- **DESCRIPCION**: esta ruta es para enviar dinero de una billetera a otra

- **REQUERIMIENTOS**: por body se requiere un objeto de tipo transferencia (dni=dni del emisor,contraseña=contraseña del emisor,cvu_emisor=cvu de la billetera del emisor,cvu_receptor=cvu de la billetera del receptor,saldo=saldo a transferir, tipo_moneda_emisor=tipo de moneda enviada, tipo_moneda_receptor=tipo de moneda recibida)

- **RESPUESTA**: vacio, comprobar con ruta get
---