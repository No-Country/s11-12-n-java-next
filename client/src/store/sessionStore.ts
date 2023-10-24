import { create } from "zustand";
import zukeeper from "zukeeper";
type Store = {
  session: UserSession;
  setSession: (newSession: UserSession) => void;
};

export const useSessionStore = create<Store>()(
  zukeeper((set: any) => ({
    session: { fullName: "", email: "", token: "" },
    setSession: (newSession: UserSession) =>
      set(() => ({ session: newSession })),
  }))
);

window.store = useSessionStore;
