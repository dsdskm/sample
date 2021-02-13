import { configure, setAddon } from '@storybook/react';
import interopRequireDefault from 'babel-runtime/helpers/interopRequireDefault';
import JSXAddon from 'storybook-addon-jsx';

function loadStories() {
  const ctx = require.context('../src/stories', true, /Story\.js/);  
  ctx.keys().forEach((srcFile) => {
    interopRequireDefault(ctx(srcFile));
  });

}

setAddon(JSXAddon);
configure(loadStories, module);