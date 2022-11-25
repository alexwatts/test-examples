const { defineConfig } = require('cypress')

module.exports = defineConfig({
  chromeWebSecurity: false,
  reporter: 'junit',
  outputs: true,
  reporterOptions: {
    outputs: "true",
    mochaFile: 'results/my-test-output.xml',
    toConsole: true
  },
  e2e: {
    enableCaptureResponses: true,
    baseUrl: 'https://www.bbc.com',
    supportFile: false,
    specPattern: 'src/test/cypress/e2e/**/*.{js,jsx,ts,tsx}',
    setupNodeEvents(on, config) {

    }
  }
})