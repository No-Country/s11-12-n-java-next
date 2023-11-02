"use client";
import React from "react";
import icon1 from "@/assets/icons/clarity_form-line.svg";
import icon2 from "@/assets/icons/Vector.svg";
import icon3 from "@/assets/icons/arcticons_formsapp.svg";
import Image from "next/image";
import Link from "next/link";
import useStore from "@/hooks/useStore";
import { useSessionStore } from "@/store/sessionStore";

export default function DashboardCard() {
  const userName = useStore(useSessionStore, (state) => state.session.fullname);

  return (
    <>
      <div className="space-y-4 px-1 mt-5">
        <div className="flex justify-center w-full mb-5">
          <div className="h-8 text-teal-700 text-3xl font-black leading-none text-center flex justify-center">
            Hola {userName?.split(" ")}!
          </div>
        </div>
        <Link
          href="/quizz"
          className="w-full h-32 bg-white rounded-3xl border-2 border-indigo-500 flex items-center p-3 gap-5"
        >
          <Image src={icon1} alt="icon1" width={68} height={67} />
          <div className="w-60 h-28 origin-top-left rotate-[-0.60deg] mt-5">
            <span className="text-teal-700 text-2xl font-normal">
              Quieres <br />
            </span>
            <span className="text-teal-700 text-2xl font-black">
              GESTIONAR
              <br />
              CUESTIONARIO
            </span>
          </div>{" "}
        </Link>
        <Link
          href="/answer"
          className="w-full h-32 bg-white rounded-3xl border-2 border-indigo-500 flex items-center p-3 gap-5"
        >
          <Image src={icon2} alt="icon1" width={52} height={53} />
          <div className="w-60 h-28 origin-top-left rotate-[-0.60deg] mt-5">
            <span className="text-teal-700 text-2xl font-normal">
              Hey, responde tus <br />
            </span>
            <span className="text-teal-700 text-2xl font-black">
              CUESTIONARIOS
              <br />
              PENDIENTES
            </span>
          </div>
        </Link>
      </div>
    </>
  );
}
