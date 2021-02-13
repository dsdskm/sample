const { storiesOf } = require("@storybook/react");

import React from "react";
import { storyOf } from "@storybook/react";
import NetCounter from '../03/NewCounter';

storiesOf('NewCounter',module).add('기본 설정',()=><NewCounter count={0}/>);