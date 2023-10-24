"use client";
import React from "react";
import { Spinner as Loader } from "@nextui-org/react";

export default function Spinner() {
  return (
    <div className="flex gap-4">
      <Loader color="secondary" size="lg" />
    </div>
  );
}
