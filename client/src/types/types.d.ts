enum RequestMethods {
  GET,
  POST,
  PATCH,
  DELETE,
}

type RequestOptions = {
  method?: string;
  headers?: Record<string, string>;
  body?: string;
};

interface ApiError extends Error {
  message: string;
}

type ApiResponse = {
  resolved: boolean;
  payload: any;
};

interface UserSession extends Omit<Passport, "password"> {
  isAuthenticated: boolean;
  token: string;
  fullname: string;
}

interface Passport {
  email: string;
  password: string;
}

interface RegisterData extends Passport {
  fullName: string;
  confirmPassword: string;
}

interface Window {
  store: ReturnType<typeof useSessionStore>;
}

interface Options {
  label: string;
  selected: boolean;
}

interface Question {
  question: string;
  answer?: string;
  options?: Options[];
}

interface Member {
  fullName: string;
  email: string;
}

interface FormSchema {
  title: string;
  description: string;
  questions?: Question[];
  members?: Member[];
}
