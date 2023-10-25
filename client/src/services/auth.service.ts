import { API_URL_LOGIN, API_URL_REGISTER } from "@/config/urlConstant";
import fetchAPIService from "./api.service";
export async function registerService(regiserData: RegisterData) {
  const res = await fetchAPIService(API_URL_REGISTER, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(regiserData),
  });
  return res;
}
export async function loginService(passport: Passport) {
  const res = await fetchAPIService(API_URL_LOGIN, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(passport),
  });
  return res;
}
