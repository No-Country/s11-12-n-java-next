"use client";
import { useForm, SubmitHandler } from "react-hook-form";
import Image from "next/image";
import logo from "@/assets/images/logo.svg";
import { Input } from "@nextui-org/react";
import Button from "@/components/ui/button/Button";
import { yupResolver } from "@hookform/resolvers/yup";
import { registerValidationSchema } from "@/validations/auth-schema.validate";

type Inputs = {
  nombre: string;
  email: string;
  password: string;
  password2: string;
};

export default function FormRegister() {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<Inputs>({
    resolver: yupResolver(registerValidationSchema),
    mode: "onBlur",
  });

  const onSubmit: SubmitHandler<Inputs> = (data) => console.log(data);

  return (
    <>
      <div className="flex h-screen flex-col p-5 items-center">
        <Image src={logo} alt="logo" width={100} className="" />
        <div className="w-[346px] h-[113px] mt-10 ">
          <span className="text-zinc-600 text-2xl font-light">
            Bienvenido a{" "}
          </span>
          <span className="text-teal-700 text-2xl font-bold">
            Quizwiz
            <br />
          </span>
          <span className="text-zinc-600 text-2xl font-light">
            introduce tus datos personales y contraseña
          </span>
        </div>
        <form
          className="w-full space-y-10 mt-5"
          onSubmit={handleSubmit(onSubmit)}
        >
          <Input
            {...register("nombre")}
            size="sm"
            type="text"
            label="Nombre Completo"
            className="border border-black rounded bg-white"
          />
          {errors.nombre?.message}
          <Input
            {...register("email")}
            size="sm"
            type="email"
            label="Correo Electrónico"
            className="border border-black rounded bg-white"
          />
          {errors.email?.message}
          <Input
            {...register("password")}
            size="sm"
            type="password"
            label="Contraseña"
            className="border border-black rounded bg-white"
          />
          {errors.password?.message}
          <Input
            {...register("password2")}
            size="sm"
            type="password"
            label="Repita nuevamente la contraseña"
            className="border border-black rounded bg-white "
          />
          {errors.password2?.message}
          <Button
            size="xl"
            className="w-full mt-20"
            type="submit"
            isDisabled={Object.keys(errors).length >= 1}
          >
            Aceptar y unirse
          </Button>
        </form>

        <div className="w-[354px] h-[53px] mt-5 leading-3 px-2">
          <span className="text-stone-900 text-[11px] font-light">
            Al hacer clic en Aceptar y unirse aceptas las{" "}
          </span>
          <span className="text-teal-700 text-[11px] font-medium">
            condiciones de uso
          </span>
          <span className="text-stone-900 text-[11px] font-light">, la </span>
          <span className="text-teal-700 text-[11px] font-medium">
            política de privacidad
          </span>
          <span className="text-stone-900 text-[11px] font-light"> y la </span>
          <span className="text-teal-700 text-[11px] font-medium">
            política de cookies{" "}
          </span>
          <span className="text-stone-900 text-[11px] font-light">
            de QUIZWIZ.
          </span>
        </div>
      </div>
    </>
  );
}
