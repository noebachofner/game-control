const baseConfig = require('@eclipse-scout/cli/scripts/webpack-defaults');

module.exports = (env, args) => {
  args.resDirArray = ['src/main/resources/WebContent', 'node_modules/@eclipse-scout/core/res'];
  const config = baseConfig(env, args);

  config.entry = {
    'scoretable': './src/main/js/scoretable.js',
    'login': './src/main/js/login.js',
    'logout': './src/main/js/logout.js',
    'scoretable-theme': './src/main/js/scoretable-theme.less',
    'scoretable-theme-dark': './src/main/js/scoretable-theme-dark.less'
  };

  return config;
};
