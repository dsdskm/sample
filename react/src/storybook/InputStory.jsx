import React from "react";
import { storiesOf } from "@storybook/react";
import Input from "./Input";
import { action } from "@storybook/addon-actions";

storiesOf("Input", module).add("기본 설정", () => (
  <Input onChange={action("onChange 이벤트 발생")} />
));
