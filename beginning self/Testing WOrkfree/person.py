from datetime import datetime, date

class Person:
    def __init__(self, name: str, birthday = datetime.today()):
        ''' initialize a new Person object.

            Args:
                name = the person's name

            Example: (doctest)
                >>> p = Person('Boom')
                >>> p.greet()
                Good morning, Boom
                >>> print(p)
                Boom

        '''
        self.__name = name
        self.__birthday = birthday

    def greet(self):
        ''' greet the person by name (depending on the time)
            if before 12, return Good morning
            else, return Good afternoon '''
        now = datetime.now()
        if now.hour < 12:
            print(f'Good morning, {self.__name}')
        else:
            print(f'Good afternoon, {self.__name}')

    def age(self):
        '''show the person age'''
        now = datetime.now()
        age = now.year - self.__birthday.year
        # if now.month <= self.__birthday.month:
        #     if now.month == self.__birthday.month and now.day < self.__birthday.day:
        #         age -= 1
        #     elif now.month < self.__birthday.month:
        #         age -= 1
        if (now.month, now.day) < (self.__birthday.month, self.__birthday.day):
            age -= 1
        print(age)

    @property
    def name(self):
        return self.__name

    def __str__(self):
        '''return name of the person'''
        return self.__name

Boom = Person('Boom Puvana', datetime(2001, 10, 8))
Boom.greet()
Boom.age()
print(Boom)


