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

interface UserSession extends Passport {
  token: string;
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
