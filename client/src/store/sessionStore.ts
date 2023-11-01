import { create } from "zustand";
import { persist, createJSONStorage } from "zustand/middleware";
import zukeeper from "zukeeper";

type Store = {
  session: UserSession;
  setSession: (newSession: UserSession) => void;
};

export const useSessionStore = create<Store>()(
  persist(
    zukeeper((set: any) => ({
      session: { fullname: "", email: "", token: "", isAuthenticated: false },
      setSession: (newSession: UserSession) =>
        set(() => ({ session: newSession })),
    })),
    {
      name: "user-storage",
      storage: createJSONStorage(() => sessionStorage),
      partialize: (state) => ({ session: state.session }),
    }
  )
);

if (typeof window !== "undefined") {
  window.store = useSessionStore;
}
