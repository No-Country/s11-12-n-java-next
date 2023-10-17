import Image from "next/image";

import ErrorLocker from "@/assets/icons/error-locker.svg"

export default function ErrorMessageModal() {
  return (
    <div className="flex flex-col items-center justify-center gap-3 p-6 bg-[#00676C] rounded-[20px] min-w-[20em] sm:min-w-[18em]">
      <Image src={ErrorLocker} alt="icono mostrando una ilustracion de un tick" width="100" height="100" />
      <p className="font-bold text-white w-[25ch] text-center">El usuario o contraseña no son válidos. Intenta nuevamente.</p>
    </div>
  )
}