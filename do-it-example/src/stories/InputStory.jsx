import React from 'react';
import { storiesOf } from '@storybook/react';
import { action } from '@storybook/addon-actions';
import { withKnobs, text, boolean, number } from '@storybook/addon-knobs';

import Input from "../03/Input";

storiesOf("Input", module).addDecorator(withKnobs)
  .addWithJSX("기본",()=> <div>야야야</div>)
  .addWithJSX("기본설정", () => <Input name="name" />)
  .addWithJSX("label 예제", () => <Input name="name" lable="이름" />)
  .addWithJSX("onChange 예제", () => <Input name="name" onChange={action("onChange 이벤트 발생")} />
  );
