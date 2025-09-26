import {RemoteApp} from '@eclipse-scout/core';
import * as scoretable from './index';

Object.assign({}, scoretable); // Use import so that it is not marked as unused

new RemoteApp().init();
