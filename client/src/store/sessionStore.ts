import { create } from "zustand";
import zukeeper from "zukeeper";

type Store = {
  session: UserSession;
  setSession: (newSession: UserSession) => void;
};

export const useSessionStore = create<Store>()(
  zukeeper((set: any) => ({
    session: { fullname: "", email: "", token: "" },
    setSession: (newSession: UserSession) =>
      set(() => ({ session: newSession })),
  }))
);

if (typeof window !== "undefined") {
  window.store = useSessionStore;
}
