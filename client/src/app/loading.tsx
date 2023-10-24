import Spinner from "@/components/ui/spinner/Spinner";
import React from "react";

export default function Loading() {
  return (
    <div className="flex w-screen h-screen justify-center items-center">
      <Spinner />
    </div>
  );
}
