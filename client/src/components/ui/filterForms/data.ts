interface Team {
  id: string;
  organizationName: string; 
  teamName: string;
  state: string;
}

interface FormState {
  id: string;
  state: string;
}

export const formState: FormState[] = [
  {
    id: crypto.randomUUID(),
    state: "En construcción"
  },
  {
    id: crypto.randomUUID(), 
    state: "Publicados"
  },
  {
    id: crypto.randomUUID(),
    state: "Cerrados"
  }
]

export const allTeams: Team[] = [
  {
    id: formState[0].id,
    organizationName: "NoCountry",
    teamName: "Cohorte s11-01",
    state: "En construcción"
  },
  {
    id: formState[0].id,
    organizationName: "NoCountry",
    teamName: "Cohorte s11-02",
    state: "En construcción"
  },
  {
    id: formState[1].id,
    organizationName: "NoCountry",
    teamName: "Cohorte s11-03",
    state: "Publicados"
  },
  {
    id: formState[1].id,
    organizationName: "NoCountry",
    teamName: "Cohorte s11-04",
    state: "Publicados"
  },
  {id: formState[2].id,
    organizationName: "NoCountry",
    teamName: "Cohorte s11-05",
    state: "Cerrados"
  },
  {
    id: formState[0].id,
    organizationName: "NoCountry",
    teamName: "Cohorte s11-06",
    state: "En construcción"
  },
  {
    id: formState[2].id,
    organizationName: "NoCountry",
    teamName: "Cohorte s11-07",
    state: "Cerrados"
  },
]