"use client";
import Landing from "@/components/landing/Landing";
import Welcome from "@/components/login/Welcome";
import { useState } from "react";

export default function Home() {
  const [isLogged, setIsLogged] = useState(true);
  return <>{isLogged ? <Landing /> : <Welcome />}</>;
}
