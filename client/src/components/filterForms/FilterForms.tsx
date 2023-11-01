"use client"

import { ChangeEvent, useState } from "react";
import Link from "next/link";
import { Button, Select, SelectItem } from "@nextui-org/react";

import FormLayout from "./FormLayout";
import TeamCard from "./TeamCard";
import { allTeams, formState } from "./data";

export default function FilterForms() {
  const [teams, setTeams] = useState(allTeams)

  const handleSelect = (e: ChangeEvent<HTMLSelectElement>) => {
    if (teams === allTeams) {
      setTeams(teams.filter(item => item.id.includes(e.target.value)))}
     else {
      setTeams(allTeams.filter(item => item.id.includes(e.target.value)))
     }
  }

  return (
  <FormLayout>  
    <div className="flex flex-col w-full flex-wrap md:flex-nowrap gap-4">
      <h3 className="text-primary text-center text-2xl font-bold">Lista de Cuestionarios</h3>
      <Select label="Selecciona" onChange={handleSelect}>
        {formState.map(item => (
          <SelectItem key={item.id} value={item.state}>{item.state}</SelectItem>
        ))}
      </Select>
    </div>
    <ul className="flex flex-col gap-4">
      {teams.length > 0 
        ? teams.map(team => (
          <li key={team.teamName}><TeamCard teamId={team.id} organizationName={team.organizationName} teamName={team.teamName} state={team.state} /></li>
        ))
        : <p className="text-slate-500 text-center">No tienes cuestionarios creados. Empieza con uno.</p> }
    </ul>
    <Link className="mx-auto" href="/quizz/new"><Button isIconOnly size="lg" radius="full"color="primary" arial-label="Generate a new form">+</Button></Link>
  </FormLayout>)
}