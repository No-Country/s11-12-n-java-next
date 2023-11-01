"use client";
import { useEffect } from "react";
import { useRouter } from "next/navigation";
import useStore from "@/hooks/useStore";
import { useSessionStore } from "@/store/sessionStore";

export default function Home() {
  const session = useStore(useSessionStore, (state) => state.session);
  const router = useRouter();

  useEffect(() => {
    if (session?.isAuthenticated) {
      router.push("/dashboard");
    } else {
      router.push("/login/landing");
    }
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [session]);

  return null;
}
