import * as Yup from "yup";

export const registerValidationSchema = Yup.object().shape({
  fullName: Yup.string()
    .required("Debes ingresar un nombre")
    .min(2, "El nombre debe ser de al menos 2 caracteres"),
  email: Yup.string()
    .email("No es un correo electrónico valido")
    .required("Se requiere de un correo electrónico"),
  password: Yup.string()
    .required("Debes ingresar una contraseña")
    .matches(
      // /^(?=.[A-Za-z])(?=.\d)[A-Za-z\d]{5,10}$/,
      /^.{5,8}$/,
      "La contrasena es invalida"
    ),
  confirmPassword: Yup.string()
    .required("Debes ingresar una contraseña")
    .oneOf([Yup.ref("password")], "Las contraseñas no coinciden"),
});

export const loginValidationSchema = Yup.object().shape({
  email: Yup.string()
    .required("Se requiere de un correo electrónico")
    .email("No es un correo electrónico valido")
    .matches(
      /^[a-zA-Z0-9.%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$/,
      "No es un correo electrónico valido"
    )
    .required("requiredEmail"),
  password: Yup.string()
    .required("Debes ingresar una contraseña")
    .matches(/^.{5,8}$/, "La contrasena es invalida"),
});
