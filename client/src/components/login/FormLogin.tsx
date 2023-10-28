"use client";
import Image from "next/image";
import logo from "@/assets/images/logo.svg";
import { useForm, SubmitHandler } from "react-hook-form";
import { yupResolver } from "@hookform/resolvers/yup";
import { Input } from "@nextui-org/react";
import { loginValidationSchema } from "@/validations/auth-schema.validate";
import { EyeFilledIcon } from "../ui/EyeFilledIcon";
import { EyeSlashFilledIcon } from "../ui/EyeSlashFilledIcon";
import Link from "next/link";
import Button from "../ui/button/Button";
import { useState } from "react";
import useSession from "@/hooks/useSession";
import { useRouter } from "next/navigation";

type Inputs = {
  email: string;
  password: string;
};

export default function FormLogin() {
  const { handleLogin } = useSession();
  const router = useRouter();
  const [isVisible, setIsVisible] = useState(false);

  const toggleVisibility = () => setIsVisible(!isVisible);

  const {
    register,
    handleSubmit,
    watch,
    formState: { errors },
  } = useForm<Inputs>({
    resolver: yupResolver(loginValidationSchema),
    mode: "onBlur",
  });

  const onSubmit: SubmitHandler<Passport> = async (data) => {
    console.log(data);
    const res = await handleLogin(data);
    res.resolved ? router.push("/dashboard") : console.log(res.payload);
    //! ver modal
  };

  return (
    <>
      <div className="flex flex-col items-center">
        <Image
          src={logo}
          alt="logo"
          height={169}
          priority
          className=" h-auto"
        />
        <h1 className="text-teal-700 font-bold text-3xl">¡Hola de nuevo!</h1>
        <p className="text-zinc-600 font-light text-sm">
          !Nos alegramos mucho de volver a verte!
        </p>
      </div>
      <div className="flex flex-col items-start w-full">
        <h2 className="text-sm uppercase font-bold text-zinc-600">
          Información de la cuenta
        </h2>
        <form
          onSubmit={handleSubmit(onSubmit)}
          className="flex flex-col gap-4 w-full"
        >
          <Input
            {...register("email")}
            size="sm"
            type="text"
            label="Email"
            className="border border-black rounded bg-white"
          />
          {errors.email?.message}
          <Input
            {...register("password")}
            size="sm"
            type={isVisible ? "text" : "password"}
            label="Contraseña"
            className="border border-black rounded bg-white"
            endContent={
              <button
                className="focus:outline-none"
                type="button"
                onClick={toggleVisibility}
              >
                {isVisible ? (
                  <EyeSlashFilledIcon className="text-2xl text-default-400 pointer-events-none" />
                ) : (
                  <EyeFilledIcon className="text-2xl text-default-400 pointer-events-none" />
                )}
              </button>
            }
          />
          {errors.password?.message}
          <Link
            href={"/login"}
            className="text-[var(--blue-link)] text-xs mt-1"
          >
            ¿Has olvidado la contraseña?
          </Link>
          <Button size="xl" className="w-full" type="submit">
            Iniciar sesión
          </Button>
        </form>
      </div>
    </>
  );
}
