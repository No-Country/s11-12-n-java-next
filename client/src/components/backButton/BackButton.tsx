"use client";
import { usePathname, useRouter } from "next/navigation";
import Image from "next/image";
import arrowBackIcon from "@/assets/icons/arrow_back.svg";

const BackButton = () => {
  const router = useRouter();
  const pathname = usePathname();

  const isNotDashboard = pathname !== "/dashboard";

  const handleVolverAtras = () => {
    router.back();
  };

  if (isNotDashboard) {
    return (
      <button
        onClick={handleVolverAtras}
        className="absolute top-0 cursor-pointer"
      >
        <Image src={arrowBackIcon} alt="go back"></Image>
      </button>
    );
  }

  return null;
};
export default BackButton;
