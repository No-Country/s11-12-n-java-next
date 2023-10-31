import React from "react";

import FormLayout from "../filterForms/FormLayout";

export default function NewFormLayout({children, subject }: {children: React.ReactNode, subject?: string}) {
  return (
    <FormLayout>
      <div className="flex flex-col justify-center">
        <h3 className="text-2xl text-primary font-bold">{subject}</h3>
        {children}
      </div>
    </FormLayout>
  )
}