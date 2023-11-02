import { getFormsService, createFormService } from "@/services/form.service";

export default function useForms() {
  const handleGetForms = async (data: FormSchema, token: string) => {
    const res = await getFormsService(data, token);

    return res;
  };

  const handleCreateForms = async (data: FormSchema, token: string) => {
    const res = await createFormService(data, token);
    if (!res.resolved) console.error("Error: ", res);

    return res;
  };

  return {
    handleGetForms,
    handleCreateForms,
  };
}
