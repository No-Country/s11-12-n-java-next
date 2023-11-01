import { getFormsService, createFormService } from "@/services/form.service"

export default function useForms() {
  const handleGetForms = async (data: FormSchema) => {
    const res = await getFormsService(data)

    return res
  }

  const handleCreateForms = async (data: FormSchema) => {
    const res = await createFormService(data)
    if (!res.resolved) console.error("Error: ", res)
    
    return res
  }

  return {
    handleGetForms, handleCreateForms
  }
}