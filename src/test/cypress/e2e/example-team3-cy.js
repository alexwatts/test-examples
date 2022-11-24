
describe('My First Test', () => {
  it('Should visit', () => {

    cy.request('GET', 'http://www.bbc.co.uk').then(
      (response) => {
         expect('Pete').to.equal('John')
      }
    )
  })
})