"use client";

import { Button as NextUiButton } from "@nextui-org/react";
import { extendVariants } from "@nextui-org/react";

interface Props {
  text: string;
  action?: () => void;
  variant: "primary" | "secondary";
}

export const Button = extendVariants(NextUiButton, {
  variants: {
    color: {
      primary: "text-primary-foreground bg-primary",
      secondary: "text-secondary-foreground bg-secondary border",
    },
    isDisabled: {
      true: "bg-[#eaeaea] text-[#000] opacity-50 cursor-not-allowed",
    },
    size: {
      xs: "px-unit-2 min-w-unit-12 h-unit-6 text-tiny gap-unit-1 rounded-full",
      md: "px-unit-4 min-w-unit-20 h-unit-8 text-small gap-unit-2 rounded-full",
      xl: "px-unit-8 min-w-unit-28 h-unit-12 text-large gap-unit-4 rounded-full",
    },
  },
  defaultVariants: {
    color: "primary",
    size: "xs",
  },
  compoundVariants: [
    {
      isDisabled: true,
      color: "primary",
      // class: "bg-[#84cc16]/80 opacity-100",
    },
  ],
});

export default Button;
